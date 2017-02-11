(ns codeit.login
  (:require [re-frame.core :as rf]
            [secretary.core :as secretary]
            [ajax.core :refer [GET POST]]
            [reagent.core :as r]))

(defn username-input [] (.getElementById js/document "user-id"))

(defn password-input [] (.getElementById js/document "password"))

(defn error-handler! [flash login-btn]
  (fn [{:keys [response]}]
    (do (reset! flash response)
        (swap! login-btn assoc :text "Login"))))

(defn login-handler! [response]
  (do (rf/dispatch [:set-token (get-in response ["access_token"])])
      (secretary/dispatch! "#/")))

(defn fake-login! [flash login-btn]
      (login-handler! {"access_token" "LKJHLJHGLJGLJKB"}))

(defn login! [flash login-btn]
  (let [username (.-value (username-input)) password (.-value (password-input))]
    (POST "http://brokers.financeone.com.au/api/token"
          {:body    (js/encodeURI (str "username=" username "&password=" password))
           :error-handler (error-handler! flash login-btn)
           :handler login-handler!})))

(defn input-change! [login-btn]
  #(swap! login-btn assoc :disabled (or (= (.-value (username-input)) "") (= (.-value (password-input)) ""))))

(defn login-page []
  (r/with-let [login-btn (r/atom {:disabled false :text "Login"}) flash (r/atom nil)]
              [:div.container
               [:div.row
                [:div.col-md-4]
                [:div.col-md-4
                 [:br]
                 [:h1.centered-header "Login"]
                 [:form
                  [:div.form-group
                   [:label "User Id:"]
                   [:input.form-control {:id "user-id"
                                         :on-change (input-change! login-btn)
                                         :on-paste (input-change! login-btn)
                                         :on-key-up (input-change! login-btn)}]]
                  [:div.form-group
                   [:label "Password:"]
                   [:input.form-control {:type "password"
                                         :id "password"
                                         :on-change (input-change! login-btn)
                                         :on-paste (input-change! login-btn)
                                         :on-key-up (input-change! login-btn)}]]
                  (when-let [flash-msg @flash]
                    [:small.flash flash-msg])
                  [:button.btn.btn-info.centered-button {:disabled (:disabled @login-btn)
                                                         :type "button"
                                                         :on-click #(do (swap! login-btn assoc :text "Please wait")
                                                                        (fake-login! flash login-btn))}
                   (:text @login-btn)]]]]]))