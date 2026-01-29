package oop;

/**
 * Complex Klasse zur Darstellung komplexer Zahlen
 */
public class Complex {

    /** Realteil der komplexen Zahl */
    private double re;
    /** Imaginaerteil der komplexen Zahl */
    private double im ;

    /** Hauptkonstruktor zur Initialisierung der komplexen Zahl
     * @param re Realteil
     * @param im Imaginaerteil
     */
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex(double re){
        this(re,0);
    }

    /** Fabrikmethode zur Erstellung einer komplexen Zahl mit nur Imaginaerteil
     * @param  im Imaginaerteil
     * @return Komplexe Zahl mit Realteil 0 und dem angegebenen Imaginaerteil
     */
    public static Complex createImaginary(double im) {
        return new Complex(0, im);
    }

    public static Complex createFromPolar(double abs, double arg){
       double re = abs * Math.cos(arg);
       double im = abs * Math.sin(arg);
       return new Complex(re, im);
    }

    public static Complex createFromPolarDeg(double abs, double argDeg){
       double arg = Math.toRadians(argDeg);
       return createFromPolar(abs, arg);
    }

    @Override
    public String toString() {
        //return String.format("%.2f+j%.2f", re, im);
        if (im==0) return re+"";
        if (im>=0) {
            if (re == 0) return "j" + im;
            return re + "+j" + im;
        }
        // else ist nicht notwendig, da nur noch der Fall im<0 uebrig ist
        if (re == 0) return "-j" + -im;
        return re + "-j" + -im;
    }

    public String toStringPolarDeg(){
       return getAbs()+"∠"+getArgDeg()+"°";
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getAbs() {
        return Math.sqrt(re*re + im*im);
    }

    public void setAbs(double abs){
       double arg = getArg();
       re = abs * Math.cos(arg);
       im = abs * Math.sin(arg);
    }

    public double getArg() {
       return Math.atan2(im, re);
    }

    public void setArg(double arg) {
       double abs  = getAbs();
       re = abs * Math.cos(arg);
       im = abs * Math.sin(arg);
    }

    public double getArgDeg(){
       return Math.toDegrees(getArg());
    }

    public void setArgDeg(double argDeg){
       setArg(Math.toRadians(argDeg));
    }

    /* -----------------------------------------------------------------------------------------------------
     * Weitere Methoden wie Addition, Subtraktion, Multiplikation, Division etc. koennen hier hinzugefuegt werden
     * -----------------------------------------------------------------------------------------------------
     */

    public Complex add(Complex c){
         return new Complex(re + c.re, im + c.im);
    }

    public Complex neg(){
         return new Complex(-re, -im);
    }

    public Complex conjugate(){
        return new Complex(re, -im);
    }

    public Complex inv(){
        /*double denom = re*re + im*im;
        return new Complex(re/denom, -im/denom);*/
        return createFromPolar(1d/getAbs(), -getArg());
    }

    public Complex sub(Complex c){
         return add(c.neg());
    }

    public Complex mul(Complex c){
        return createFromPolar(c.getAbs()*getAbs(), c.getArg()+getArg());
    }

    public Complex div(Complex c){
        return createFromPolar(getAbs()/c.getAbs(), getArg()-c.getArg());
    }

}
