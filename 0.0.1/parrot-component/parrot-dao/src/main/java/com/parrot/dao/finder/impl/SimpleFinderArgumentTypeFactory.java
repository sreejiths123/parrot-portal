package com.parrot.dao.finder.impl;

import org.hibernate.type.Type;

import com.parrot.dao.finder.FinderArgumentTypeFactory;


/**
 * Maps Enums to a custom Hibernate user type
 */
public class SimpleFinderArgumentTypeFactory implements FinderArgumentTypeFactory
{
    public Type getArgumentType(Object arg)
    {
//        if(arg instanceof Enum)
//        {
//            return getEnumType(arg.getClass());
//        }
//        else
//        {
            return null;
//        }
    }

//    private Type getEnumType(Class<? extends Object> argClass)
//    {
//        Properties p = new Properties();
//        p.setProperty("enumClassName", argClass.getName());
//        Type enumType = TypeFactory.heuristicType("org.hibernate.demo.EnumUserType", p);
//        return enumType;
//    }
}
