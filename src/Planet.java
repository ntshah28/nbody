public class Planet {
    double myXPos;
    double myYPos;
    double myXVel;
    double myYVel;
    double myMass;
    String myFileName;

    public Planet(double mxp, double myp, double mxv, double myv, double m, String f) {
        myXPos = mxp;
        myYPos = myp;
        myXVel = mxv;
        myYVel = myv;
        myMass = m;
        myFileName = f;
    }

    public Planet(Planet p) {
        myXPos = p.myXPos;
        myYPos = p.myYPos;
        myXVel = p.myXVel;
        myYVel = p.myYVel;
        myMass = p.myMass;
        myFileName = p.myFileName;
    }

    public double calcDistance(Planet p) {
        double distance = Math.sqrt(Math.pow(myXPos-p.myXPos,2)+Math.pow(myYPos-p.myYPos,2));
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        double gravity = 6.67*Math.pow(10,-11);
        double mass1 = this.myMass;
        double mass2 = p.myMass;
        double dist = this.calcDistance(p);
        return (gravity*mass1*mass2)/(Math.pow(dist,2));
    }
}
