(ns codeit.home)

(defn home-page []
  [:div.container
   [:div.row]
   [:div.col-md-12
    [:br]
    [:h1.centered-header (str "Welcome, " "Caleb MacDonald Black")]
    [:div.col-md-4]
    [:div.col-md-4.menu-btn
     [:span.glyphicon.glyphicon-print] "hello"]
    [:div.col-md-4]]])