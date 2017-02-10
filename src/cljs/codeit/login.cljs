(ns codeit.login
  (:require [codeit.validation :as validation]
    [ajax.core :refer [GET POST]]))

(defn login []
  (let [username (.-value (.getElementById js/document "user-id")) password (.-value (.getElementById js/document "password"))]
    (POST "http://brokers.financeone.com.au/api/token"
          {;:body (str "username="  "&password=")
           :body    (js/encodeURI (str "username=" username "&password=" password))
           :handler #(js/alert %)})))

(defn login-page []
  [:div.container
   [:div.row
    [:div.col-md-4]
    [:div.col-md-4
     [:br]
     [:h1.centered-header "Login"]
     [:form
      [:div.form-group
       [:label "User Id:"]
       [:input.form-control {:id "user-id"}]]
      [:div.form-group
       [:label.fo "Password:"]
       [:input.form-control {:type "password" :id "password"}]]
      [:button.btn.btn-info.centered-button {:type "submit" :on-click #(login)} "Login"]]]]])