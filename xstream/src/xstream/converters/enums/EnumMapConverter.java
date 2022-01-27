/*
 * Copyright (C) 2005 Joe Walnes.
 * Copyright (C) 2006, 2007, 2008, 2009 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 06. April 2005 by Joe Walnes
 */

// ***** READ THIS *****
// This class will only compile with JDK 1.5.0 or above as it test Java enums.
// If you are using an earlier version of Java, just don't try to build this class. XStream should work fine without it.

package xstream.converters.enums;

import xstream.converters.ConversionException;
import xstream.converters.MarshallingContext;
import xstream.converters.UnmarshallingContext;
import xstream.converters.collections.MapConverter;
import xstream.core.util.Fields;
import xstream.io.HierarchicalStreamReader;
import xstream.io.HierarchicalStreamWriter;
import xstream.mapper.Mapper;

import java.lang.reflect.Field;
import java.util.EnumMap;

/**
 * Serializes an Java 5 EnumMap, including the type of Enum it's for. If a SecurityManager is set, the converter will only work with permissions
 * for SecurityManager.checkPackageAccess, SecurityManager.checkMemberAccess(this, EnumSet.MEMBER)
 * and ReflectPermission("suppressAccessChecks").
 *
 * @author Joe Walnes
 */
public class EnumMapConverter extends MapConverter {

    private final static Field typeField;
    static {
        // field name is "keyType" in Sun JDK, but different in IKVM
        Field assumedTypeField = null;
        try {
            Field[] fields = EnumMap.class.getDeclaredFields();
            for (int i = 0; i < fields.length; i++ ) {
                if (fields[i].getType() == Class.class) {
                    // take the fist member of type "Class"
                    assumedTypeField = fields[i];
                    assumedTypeField.setAccessible(true);
                    break;
                }
            }
            if (assumedTypeField == null) {
                throw new ExceptionInInitializerError("Cannot detect key type of EnumMap");
            }

        } catch (SecurityException ex) {
            // ignore, no access possible with current SecurityManager
        }
        typeField = assumedTypeField;
    }

    public EnumMapConverter(Mapper mapper) {
        super(mapper);
    }

    public boolean canConvert(Class type) {
        return typeField != null && type == EnumMap.class;
    }

    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Class type = (Class) Fields.read(typeField, source);
        String attributeName = mapper().aliasForSystemAttribute("enum-type");
        if (attributeName != null) {
            writer.addAttribute(attributeName, mapper().serializedClass(type));
        }
        super.marshal(source, writer, context);
    }

    @SuppressWarnings("unchecked")
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        String attributeName = mapper().aliasForSystemAttribute("enum-type");
        if (attributeName == null) {
            throw new ConversionException("No EnumType specified for EnumMap");
        }
        Class type = mapper().realClass(reader.getAttribute(attributeName));
        EnumMap map = new EnumMap(type);
        populateMap(reader, context, map);
        return map;
    }
}
