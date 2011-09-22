package org.srplib.conversion.adapters;

import org.apache.commons.collections15.Transformer;
import org.srplib.contract.Argument;
import org.srplib.conversion.Converter;

/**
 * A adapter for commons collections {@link org.apache.commons.collections15.Transformer}.
 *
 * <p>Transformer15Adapter is a good way to reuse existing converters with rich set of utility methods of
 * {@link org.apache.commons.collections15.CollectionUtils}.
 *
 * <pre>
 *     Converter converter = ....
 *     ...
 *     Collection result = CollectionUtils.collect(collection, new Transformer15Adapter(converter));
 * </pre>
 * <p>
 *
 * @author Q-APE
 */
public class Transformer15Adapter<I, O> implements Transformer<I, O> {

    private Converter<I, O> converter;

    public Transformer15Adapter(Converter<I, O> converter) {
        Argument.checkNotNull(converter, "Converter should not be null!");
        this.converter = converter;
    }

    @Override
    public O transform(I source) {
        return converter.convert(source);
    }
}