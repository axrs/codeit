(ns codeit.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [codeit.core-test]))

(doo-tests 'codeit.core-test)

