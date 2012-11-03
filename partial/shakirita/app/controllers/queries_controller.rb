require 'json'

class QueriesController < ApplicationController

  # GET /queries/1
  # GET /queries/1.json
  def search
  end

  def results
    @query = params[:q]
    @results1 = ""
    response = HTTParty.get('http://localhost:3000/nodes.json')

    response.each do |item|
      @url = item+"/searching?q="+@query
      calling = HTTParty.get(@url)
    end

    response = HTTParty.get('http://localhost:3000/nodes.json')
    response.each do |item|
      files = HTTParty.get(item+"/temp.json")
      files.each do |file|
        if file != ""
          @results1 = file + " " + @results1
        end
      end
    end

    
=begin
    @files = Dir.glob("public/*")
    Array.new
    
    for file in @files
      temp = file[7..6+@query.size]
      if temp != @query
        file.clear
      end
    end

    #render :json => @files
    File.open("public/temp1.json","w") do |f|
      f.write(@files.to_json)
    end
=end
    
    #respond_to do |format|
      #format.html # show.html.erb
      #format.json { render json: @query }
    #end
  end

end
