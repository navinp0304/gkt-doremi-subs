package com.example.geektrust;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddStreamUnique {
	private final Set<Integer> subscriptions = new HashSet<Integer>();

	private Boolean addState(IStream stream, List<IStream> streams) {
		subscriptions.add(stream.getOffset());
		streams.add(stream);
		return true;
	}

	private Boolean createDuplicateException() {
		throw new IllegalArgumentException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
	}

	Boolean addStreamUnique(IStream stream, List<IStream> streams) {
		return subscriptions.contains(stream.getOffset()) ? createDuplicateException() : addState(stream, streams);
	}
}