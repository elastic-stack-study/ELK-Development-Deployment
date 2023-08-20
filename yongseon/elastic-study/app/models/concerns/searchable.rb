# frozen_string_literal: true

module Searchable
  extend ActiveSupport::Concern

  included do
    include Elasticsearch::Model
    include Elasticsearch::Model::Callbacks

    # Define a search method
    def self.search_by(query)
      search(query)
    end

    def self.search_by_name(name)
      search({
               query: {
                 match: { name: name }
               }
        })
    end
  end

  class_methods do
    # If needed, you can add more class-level methods here
  end
end

