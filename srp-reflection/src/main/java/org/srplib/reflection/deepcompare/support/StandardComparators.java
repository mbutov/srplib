package org.srplib.reflection.deepcompare.support;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.srplib.conversion.Converter;
import org.srplib.conversion.mapper.MatcherMapBuilder;
import org.srplib.reflection.deepcompare.DeepComparator;
import org.srplib.reflection.deepcompare.comparators.EqualsDeepComparator;
import org.srplib.reflection.deepcompare.comparators.ListDeepComparator;
import org.srplib.reflection.deepcompare.comparators.MapDeepComparator;
import org.srplib.reflection.deepcompare.comparators.ReflectionDeepComparator;
import static org.hamcrest.Matchers.typeCompatibleWith;


/**
 * Standard comparator registry.
 *
 * @author Anton Pechinsky
 */
public class StandardComparators implements Converter<Class, DeepComparator> {

    private final Converter<Class<?>, DeepComparator> comparators = MatcherMapBuilder.<Class<?>, DeepComparator>create()

        .map(new IsPrimitiveMatcher(), new EqualsDeepComparator())

        .map(new IsPrimitiveWrapperMatcher(), new EqualsDeepComparator())

        .map(typeCompatibleWith(String.class), new EqualsDeepComparator())

        .map(typeCompatibleWith(Date.class), new EqualsDeepComparator())

        .map(typeCompatibleWith(Enum.class), new EqualsDeepComparator())

        .map(typeCompatibleWith(List.class), new ListDeepComparator())

        .map(typeCompatibleWith(Map.class), new MapDeepComparator())

        .map(typeCompatibleWith(Set.class), new EqualsDeepComparator())

        .setDefaultValue(new ReflectionDeepComparator())

        .build();

    @Override
    public DeepComparator convert(Class input) {
        return comparators.convert(input);
    }
}
