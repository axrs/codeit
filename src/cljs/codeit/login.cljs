(ns codeit.login)

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