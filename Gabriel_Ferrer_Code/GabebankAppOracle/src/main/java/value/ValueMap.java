package value;

import java.util.EnumMap;

public class ValueMap {
	public static EnumMap<Currency, String> currency =
	         new EnumMap<Currency, String>(Currency.class);
	static {
		currency.put(Currency.EUR, "EUR");
		currency.put(Currency.USD, "USD");
	}
}
