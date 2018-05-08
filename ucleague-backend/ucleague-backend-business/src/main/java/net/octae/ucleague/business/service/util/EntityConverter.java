package net.octae.ucleague.business.service.util;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class EntityConverter {
	
	@Autowired
    private Mapper mapper;
	
	public <F, T> T fill(F source, T destination) {
		if (source == null || destination == null) {
			return null;
		}
		mapper.map(source, destination);
		return destination;
	}

	public <F, T> Iterable<T> convert(Iterable<F> fromIterable, final Class<T> toClass) {

		return StreamSupport.stream(fromIterable.spliterator(), false)
				.map(from -> convert(from, toClass))
				.collect(Collectors.toList());
	}

	public <F, T> List<T> convert(List<F> fromList, final Class<T> toClass) {

		return fromList.stream()
				.map(from -> convert(from, toClass))
				.collect(Collectors.toList());
	}

	public <F, T> Page<T> convert(Page<F> fromPage, final Class<T> toClass) {

		return fromPage.map(from ->  convert(from, toClass));
	}

	public <F, T> T convert(F from, final Class<T> toClass) {
		if (from == null) {
			return null;
		}
		return mapper.map(from, toClass);
	}
}
