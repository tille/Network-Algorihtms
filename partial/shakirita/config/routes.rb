Shakirita::Application.routes.draw do
  get "search/index"

  root :to => 'queries#search'
  match "/searching" => "queries#results"
end
