package com.codeaspect.tern.fw

class Converter[I,O](val hasError :Boolean, val error :Throwable) {
	
}

object Converter{
  def apply = new Converter(false,null)
}