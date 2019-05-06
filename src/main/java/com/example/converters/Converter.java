/*
 * 
 */
 package com.example.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

public interface Converter<S, T> extends org.springframework.core.convert.converter.Converter<S, T> {

	default List<T> convertAll(final Collection<? extends S> sources) {
		if (CollectionUtils.isEmpty(sources)) {
			return Collections.emptyList();
		} else {
			final ArrayList<T> resultList = new ArrayList<T>(sources.size());
			final Iterator iterator = sources.iterator();
			while (iterator.hasNext()) {
				final S source = (S) iterator.next();
				resultList.add(this.convert(source));
			}
			return resultList;
		}
	}

}
