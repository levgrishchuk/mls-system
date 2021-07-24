package app;

import com.google.gson.*;
import java.lang.reflect.Type;

/**
 * For serializing/deserializing abstract/interface/super classes
 * @param <T>
 */
public class TypeAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    @Override
    public final JsonElement serialize(final T object, final Type type, final JsonSerializationContext context)
    {
        final JsonObject member = new JsonObject();

        member.addProperty("typeName", object.getClass().getName());

        member.add("data", context.serialize(object));

        return member;
    }

    @Override
    public final T deserialize(final JsonElement elem, final Type type, final JsonDeserializationContext context)
            throws JsonParseException
    {
        final JsonObject member = (JsonObject) elem;
        final JsonElement typeString = get(member, "typeName");
        final JsonElement data = get(member, "data");
        final Type actualType = typeForName(typeString);

        return context.deserialize(data, actualType);
    }

    private Type typeForName(final JsonElement typeElem)
    {
        try
        {
            return Class.forName(typeElem.getAsString());
        }
        catch (ClassNotFoundException e)
        {
            throw new JsonParseException(e);
        }
    }

    private JsonElement get(final JsonObject wrapper, final String memberName)
    {
        final JsonElement elem = wrapper.get(memberName);

        if (elem == null)
        {
            throw new JsonParseException(
                    "no '" + memberName + "' member found in json file.");
        }
        return elem;
    }
}