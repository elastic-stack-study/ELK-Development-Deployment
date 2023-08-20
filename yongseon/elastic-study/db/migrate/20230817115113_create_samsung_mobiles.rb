class CreateSamsungMobiles < ActiveRecord::Migration[7.0]
  def change
    SamsungMobile.__elasticsearch__.create_index!
  end
end
