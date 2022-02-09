/*
 * Copyright (C) 2006 Joe Walnes.
 * Copyright (C) 2006, 2007, 2008, 2011 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 22. June 2006 by Mauro Talevi
 */
package xstream.io.json;

import xstream.io.AbstractDriver;
import xstream.io.HierarchicalStreamReader;
import xstream.io.HierarchicalStreamWriter;
import xstream.io.StreamException;
import xstream.io.naming.NameCoder;

import java.io.*;
import java.net.URL;

/**
 * A driver for JSON that writes optimized JSON format, but is not able to deserialize the result.
 * 
 * @author Paul Hammant
 * @since 1.2
 */
public class JsonHierarchicalStreamDriver extends AbstractDriver {

    /**
     * Construct a JsonHierarchicalStreamDriver.
     */
    public JsonHierarchicalStreamDriver() {
        super();
    }

    /**
     * Construct a JsonHierarchicalStreamDriver with name coding.
     * 
     * @param nameCoder the coder to encode and decode the JSON labels.
     * @since 1.4.2
     */
    public JsonHierarchicalStreamDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public HierarchicalStreamReader createReader(Reader in) {
        throw new UnsupportedOperationException("The JsonHierarchicalStreamDriver can only write JSON");
    }

    public HierarchicalStreamReader createReader(InputStream in) {
        throw new UnsupportedOperationException("The JsonHierarchicalStreamDriver can only write JSON");
    }

    public HierarchicalStreamReader createReader(URL in) {
        throw new UnsupportedOperationException("The JsonHierarchicalStreamDriver can only write JSON");
    }

    public HierarchicalStreamReader createReader(File in) {
        throw new UnsupportedOperationException("The JsonHierarchicalStreamDriver can only write JSON");
    }

    /**
     * Create a HierarchicalStreamWriter that writes JSON.
     */
    public HierarchicalStreamWriter createWriter(Writer out) {
        return new JsonWriter(out);
    }

    public HierarchicalStreamWriter createWriter(OutputStream out) {
        try {
            // JSON spec requires UTF-8
            return createWriter(new OutputStreamWriter(out, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new StreamException(e);
        }
    }

}
