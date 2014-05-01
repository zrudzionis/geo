package org.geotools.main;

import handlers.ExportShapeFileAction;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.geotools.data.DataUtilities;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.FactoryFinder;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapPane;
import org.geotools.swing.action.PanAction;
import org.geotools.swing.action.ResetAction;
import org.opengis.feature.simple.SimpleFeature;

import SetsRelated.GeometrySet;
import SetsRelated.IntersectTest;

import com.vividsolutions.jts.geom.*;

import windows.MainWindow;

/*
 * + add/remove layer
 * + show/hidden layer
 * + zoom in/zoom out
 * + pan (postumis)
 * + full extent (grizimas i pradini vaizda)
 * + select / multiselect
 * + zoom to select
 * + show attribute data referencing selected map content / show map content referencing selected attribute data
 * + display layer attribute data
 * + object search relied on supplied attribute values
 */

public class Main {

    public static MainWindow mainWindow;

    public static void main(String[] args) throws Exception {

        try {

            mainWindow = new MainWindow(null, 1200, 600);

           // long startTime = System.nanoTime();

            //Main.test();
//            long endTime = System.nanoTime();
//            System.out.println("Took " + (endTime - startTime) / 60000000000.0
//                    + " min");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void test() {

        String path = "C:\\Users\\as\\Desktop\\gis\\LTsventoji\\";
        SimpleFeatureSource simpleFeatureSourceKeliai = Support
                .loadShapeFile(path + "sven_KEL_L.shp");
        SimpleFeatureSource simpleFeatureSourceApskritys = Support
                .loadShapeFile(path + "sven_SAV_P.shp");

        try {

            GeometrySet geometrySet = new GeometrySet();

            SimpleFeatureSource intersectSimpleFeatureSource = geometrySet
                    .intersect(simpleFeatureSourceApskritys,simpleFeatureSourceKeliai
                            , 1);

            Layer intersectLayer = Support
                    .simpleFeatureSourceToLayer(intersectSimpleFeatureSource);

            Main.mainWindow.addLayer(intersectLayer);
            sop("Done intersecting!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    public static void sop(String string) {
        System.out.println(string);
    }
}