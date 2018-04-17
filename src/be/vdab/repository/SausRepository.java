package be.vdab.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Saus;

public class SausRepository {
	private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();
	static {
		SAUZEN.put(3L, new Saus(3, "cocktail", Arrays.asList("room", "ketchup", "paprikapoeder")));
		SAUZEN.put(6L, new Saus(6, "mayonaise", Arrays.asList("ei", "room")));
		SAUZEN.put(7L, new Saus(7, "mosterd", Arrays.asList("mosterdzaad", "azijn", "zout")));
		SAUZEN.put(12L, new Saus(12, "tartare", Arrays.asList("peterselie", "bieslook", "mayonaise")));
		SAUZEN.put(44L, new Saus(44, "vinaigrette", Arrays.asList("azijn")));
	}
	
	public List<Saus> findAll() {
		return new ArrayList<>(SAUZEN.values());
	}
}
