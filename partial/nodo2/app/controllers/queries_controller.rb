require 'json'

class QueriesController < ApplicationController

  # GET /queries/1
  # GET /queries/1.json
  def search
  end

  def results
    @query = params[:q]
    @files = Dir.glob("public/*")
    Array.new
    
    for file in @files
      temp = file[7..6+@query.size]
      if temp != @query
        file.clear
      end
    end

    #render :json => @files
    File.open("public/temp.json","w") do |f|
      f.write(@files.to_json)
    end
    
    #respond_to do |format|
      #format.html # show.html.erb
      #format.json { render json: @query }
    #end
  end

end
