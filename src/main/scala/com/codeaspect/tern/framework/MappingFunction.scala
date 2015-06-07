package com.codeaspect.tern.framework

class MappingFunction[U, V](val name: String, val sourceType: Class[U], val targetType: Class[V], val map: U => V) {

  //Makes pattern matching easy
  def unapply(source: (Class[Any], Class[Any])) = source match {
    case (source: Class[Any], target: Class[Any]) => 
      if (source == sourceType && target == targetType) 
        true
        else 
          false
  }

}