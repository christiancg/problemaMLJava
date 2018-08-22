package com.ccg.problemaML.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ccg.problemaML.models.Clima;
import com.ccg.problemaML.models.Planet;
import com.ccg.problemaML.service.IClimaCalculatorService;
import com.ccg.problemaML.views.Point;

@Service
public class ClimateCalculatorService implements IClimaCalculatorService{
    public Clima calculateClimate(Planet ferengi, Planet betasoide, Planet vulcano, int days)
    {
        Clima resultado = null;
        ferengi.ResetPosition();
        ferengi.OrbitDays(days);
        betasoide.ResetPosition();
        betasoide.OrbitDays(days);
        vulcano.ResetPosition();
        vulcano.OrbitDays(days);
        Point posFerengi = new Point(ferengi.getDistance(), ferengi.getAngle());
        Point posBetasoide = new Point(betasoide.getDistance(), betasoide.getAngle());
        Point posVulcano = new Point(vulcano.getDistance(), vulcano.getAngle());
        Point sun = new Point(0, 0);
        if (checkColinear(posBetasoide, posFerengi, posVulcano, sun))
            resultado = new Clima("sequia", 0);
        else if (checkColinear(posBetasoide, posFerengi, posVulcano))
            resultado = new Clima("optimo", 0);
        else if (insideTriangle(posFerengi, posBetasoide, posVulcano, sun))
        {
            double rainQty = getPerimeter(posBetasoide, posFerengi, posVulcano);
            resultado = new Clima("lluvia", rainQty);
        }
        else
            resultado = new Clima("indeterminado", 0);
        return resultado;
    }

    private boolean checkColinear(Point p1, Point p2, Point p3, Point reference)
    {

        List<Double> lSlope = new ArrayList<Double>();
        double auxS = p2.getX() - p1.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
        lSlope.add(auxS);
        lSlope.add(p3.getX() - p2.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(p3.getY() - p2.getY()) / (p3.getX() - p2.getX())));
        lSlope.add(p1.getX() - p3.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(p1.getY() - p3.getY()) / (p1.getX() - p3.getX())));
        lSlope.add(reference.getX() - p3.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(reference.getY() - p3.getY()) / (reference.getX() - p3.getX())));
        lSlope.add(reference.getX() - p2.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(reference.getY() - p2.getY()) / (reference.getX() - p2.getX())));
        lSlope.add(reference.getX() - p1.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(reference.getY() - p1.getY()) / (reference.getX() - p1.getX())));
        return lSlope.stream().allMatch(x -> x == auxS);
    }

    private boolean checkColinear(Point p1, Point p2, Point p3)
    {
        List<Double> lSlope = new ArrayList<Double>();
        double auxS = p2.getX() - p1.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
        lSlope.add(auxS);
        lSlope.add(p3.getX() - p2.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(p3.getY() - p2.getY()) / (p3.getX() - p2.getX())));
        lSlope.add(p1.getX() - p3.getX() == 0 ? Double.MAX_VALUE : Math.round((double)(p1.getY() - p3.getY()) / (p1.getX() - p3.getX())));
        return lSlope.stream().allMatch(x -> x == auxS);
    }

    /* A utility function to calculate area of triangle 
formed by (x1, y1) (x2, y2) and (x3, y3) */
    private double area(Point p1, Point p2, Point p3)
    {
        return Math.abs((p1.getX() * (p2.getY() - p3.getY()) +
                         p2.getX() * (p3.getY() - p1.getY()) +
                         p3.getX() * (p1.getY() - p2.getY())) / 2.0);
    }

    /* A function to check whether point P(x, y) lies
    inside the triangle formed by A(x1, y1),
    B(x2, y2) and C(x3, y3) */
    private boolean insideTriangle(Point p1, Point p2, Point p3, Point sun)
    {
        /* Calculate area of triangle ABC */
        double A = area(p1, p2, p3);
        /* Calculate area of triangle PBC */
        double A1 = area(sun, p2, p3);
        /* Calculate area of triangle PAC */
        double A2 = area(p1, sun, p3);
        /* Calculate area of triangle PAB */
        double A3 = area(p1, p2, sun);
        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    private double getPerimeter(Point p1, Point p2, Point p3)
    {
        double side1 = Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2));
        double side2 = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        double side3 = Math.sqrt(Math.pow(p3.getX() - p1.getX(), 2) + Math.pow(p3.getY() - p1.getY(), 2));
        return side1 + side2 + side3;
    }
}
