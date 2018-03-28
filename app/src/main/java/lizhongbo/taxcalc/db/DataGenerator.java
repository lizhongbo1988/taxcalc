/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lizhongbo.taxcalc.db;


import java.util.ArrayList;
import java.util.List;

import lizhongbo.taxcalc.db.entity.TaxEntity;

/**
 * Generates data to pre-populate the database
 */
public class DataGenerator {
    private List<TaxEntity> taxEntityList = new ArrayList<>();
    public static List<TaxEntity> generateTax() {
        List<TaxEntity> taxEntityArrayList = new ArrayList<>();

        TaxEntity t1 = new TaxEntity(1,1500, 0.03, 0);
        taxEntityArrayList.add(t1);

        TaxEntity t2 = new TaxEntity(2, 4500,0.1, 105);
        taxEntityArrayList.add(t2);

        TaxEntity t3 = new TaxEntity(3, 9000,0.2, 555);
        taxEntityArrayList.add(t3);
        TaxEntity t4 = new TaxEntity(4, 35000,0.25, 1005);
        taxEntityArrayList.add(t4);

        TaxEntity t5 = new TaxEntity(5, 55000,0.3, 2755);
        taxEntityArrayList.add(t5);

        TaxEntity t6 = new TaxEntity(6, 80000,0.35, 5505);
        taxEntityArrayList.add(t6);

        TaxEntity t7 = new TaxEntity(7, 80001, 0.45, 13505);
        taxEntityArrayList.add(t7);
        return taxEntityArrayList;
    }
}
