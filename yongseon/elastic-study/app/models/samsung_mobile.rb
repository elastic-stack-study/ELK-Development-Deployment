require 'elasticsearch/model'

class SamsungMobile < ApplicationRecord
  include Searchable

  settings index: { number_of_shards: 1 } do
    mappings dynamic: 'false' do
      indexes :name, analyzer: 'english'
      indexes :rating, analyzer: 'english'
      indexes :price, analyzer: 'english'
      indexes :camera, analyzer: 'english'
      indexes :display, analyzer: 'english'
      indexes :battery, analyzer: 'english'
      indexes :storage, analyzer: 'english'
      indexes :ram, analyzer: 'english'
      indexes :processor, analyzer: 'english'
      indexes :android_version, analyzer: 'english'
    end
  end
end
