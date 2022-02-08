/*
 * Copyright (C) 2005 Joe Walnes.
 * Copyright (C) 2006, 2007, 2008, 2009, 2011 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 16. September 2005 by Mauro Talevi
 */
package xstream.annotations;

import xstream.XStream;
import xstream.converters.ConverterMatcher;

import java.lang.annotation.*;


/**
 * Annotation to declare a converter. The annotation supports additionally the injection of
 * various constructor arguments provided by XStream:
 * <ul>
 * <li>{@link xstream.mapper.Mapper}: The current mapper chain of the XStream
 * instance.</li>
 * <li>{@link ClassLoader}: The class loader used by the XStream instance to deserialize the
 * objects.</li>
 * <li>{@link xstream.converters.reflection.ReflectionProvider}: The reflection
 * provider used by the reflection based converters of the current XStream instance.</li>
 * <li>{@link xstream.converters.ConverterLookup}: The lookup for converters
 * handling a special type.</li>
 * <li>{@link xstream.core.JVM}: Utility e.g. to load classes.</li>
 * <li>All elements provided with the individual arrays of this annotation.</li>
 * <li>{@link Class}: The type of the element where the annotation is declared. Note, that this
 * argument is not supported when using
 * {@link xstream.annotations.XStreamConverters}.</li>
 * </ul>
 * <p>
 * Note, the annotation matches a {@link ConverterMatcher}.
 * {@link xstream.converters.ConverterMatcher} as well as
 * {@link xstream.converters.SingleValueConverter} extend this interface. The
 * {@link xstream.mapper.AnnotationMapper} can only handle these two
 * <strong>known</strong> types.
 * </p>
 * 
 * @author Chung-Onn Cheong
 * @author J&ouml;rg Schaible
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Documented
public @interface XStreamConverter {
    Class<? extends ConverterMatcher> value();
    int priority() default XStream.PRIORITY_NORMAL;
    Class<?>[] types() default {};
    String[] strings() default {};
    byte[] bytes() default {};
    char[] chars() default {};
    short[] shorts() default {};
    int[] ints() default {};
    long[] longs() default {};
    float[] floats() default {};
    double[] doubles() default {};
    boolean[] booleans() default {};
}