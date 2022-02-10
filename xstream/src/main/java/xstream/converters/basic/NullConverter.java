/*
 * Copyright (C) 2003, 2004 Joe Walnes.
 * Copyright (C) 2006, 2007 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 03. October 2003 by Joe Walnes
 */
package xstream.converters.basic;

import xstream.converters.Converter;
import xstream.converters.MarshallingContext;
import xstream.converters.UnmarshallingContext;
import xstream.io.ExtendedHierarchicalStreamWriterHelper;
import xstream.io.HierarchicalStreamReader;
import xstream.io.HierarchicalStreamWriter;
import xstream.mapper.Mapper;

/**
 * Special converter to signify nulls at the root level.
 *
 * @author Joe Walnes
 */
public class NullConverter implements Converter {

    public boolean canConvert(Class type) {
        return type == null || Mapper.Null.class.isAssignableFrom(type);
    }

    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        ExtendedHierarchicalStreamWriterHelper.startNode(writer, "null", null);
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return null;
    }
}