require 'rubygems'
require 'httparty'

class SearchController < ApplicationController
  def index
    @response = HTTParty.get('http://localhost:3001/temp1.json')
  end
end
