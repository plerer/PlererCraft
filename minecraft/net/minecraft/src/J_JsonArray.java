// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            J_JsonRootNode, EnumJsonNodeType, J_JsonNodeList

final class J_JsonArray extends J_JsonRootNode
{

    private final List elements;

    J_JsonArray(Iterable iterable)
    {
        elements = asList(iterable);
    }

    public EnumJsonNodeType getType()
    {
        return EnumJsonNodeType.ARRAY;
    }

    public List getElements()
    {
        return new ArrayList(elements);
    }

    public String getText()
    {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
    }

    public Map getFields()
    {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            J_JsonArray j_jsonarray = (J_JsonArray)obj;
            return elements.equals(j_jsonarray.elements);
        }
    }

    public int hashCode()
    {
        return elements.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("JsonArray elements:[").append(elements).append("]").toString();
    }

    private static List asList(Iterable iterable)
    {
        return new J_JsonNodeList(iterable);
    }
}
