package com.codeaspect.tern.framework

class TernContext(val providers: Vector[LookupProvider], val converters: Vector[MappingFunction[Any, Any]]) {

  def TernContext() = new TernContext(Vector(), Vector())

  def addLookupProvider(provider: LookupProvider) = 
    new TernContext(providers :+ provider, converters)

  def removeLookupProvider(name: String) = 
    new TernContext(providers filter { _.name != name }, converters)

  def addMappingFunction(name: String, fn: MappingFunction[Any, Any]) = 
    new TernContext(providers, converters :+ fn)

  def removeMappingFunction(name: String) = 
    new TernContext(providers, converters filter { _.name != name })

  def removeMappingFunctions[U, V](source: Class[U], target: Class[V]) = 
    new TernContext(providers, converters filter {p => p.sourceType == source && p.targetType == target})

}

