class SamsungMobilesController < ApplicationController

  def index
    @mobiles = SamsungMobile.search_by(size: 10).results
  end

  def search
    @mobiles = SamsungMobile.search_by_name(params[:keyword]).results
    render partial: 'results', formats: [:js]
  end
end
