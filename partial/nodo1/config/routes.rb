Nodo1::Application.routes.draw do
  resources :queries

  get "welcome/index"

  root :to => 'welcome#index'
  match "/query" => "queries#search"
  match "/searching" => "queries#results"
end
