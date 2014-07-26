package com.codeaspect.tern.fw

import java.lang.reflect.ParameterizedType

class Convertable[I,O] {

  val fields = getClass().getDeclaredFields() filter (_.getType().isAssignableFrom(classOf[Converter[Any,Any]]))
  
  fields.par.foreach (fld => {
    fld.getGenericType() match {
      case p :ParameterizedType => {
        val types = p.getActualTypeArguments();
        fld.set(this, new Converter[Any,Any](false,null))
      }
      case _  => assert(false,"Converter must be parameterized.")
    }
  })
  
}