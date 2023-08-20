Rails.application.routes.draw do
  # Define your application routes per the DSL in https://guides.rubyonrails.org/routing.html

  # Defines the root path route ("/")
  root 'samsung_mobiles#index'

  get 'samsung_mobiles/search', to: 'samsung_mobiles#search'
end
