package com.codeaspect.tern.framework

trait LookupProvider {
  
  def name() : String
  
  def lookup(store: String, key : String)

}