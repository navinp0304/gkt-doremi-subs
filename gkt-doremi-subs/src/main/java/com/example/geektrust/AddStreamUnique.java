package com.example.geektrust;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddStreamUnique {
	Set<Integer> subscriptions = new HashSet<Integer>();
	
	Boolean duplicateFound() {
		return false;
	}
	
	Boolean addState(IStream stream,List<IStream> streams) {
		subscriptions.add(stream.getOffset());
		streams.add(stream);
		return true;
	}
	
	Boolean addStreamUnique(IStream stream,List<IStream> streams) {
		 return subscriptions.contains(stream.getOffset())?duplicateFound():addState(stream,streams);
	}
}