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

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.myXPos - this.myXPos) / p.calcDistance(this);
    }
    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.myYPos - this.myYPos) / p.calcDistance(this);
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double sum=0.0;
        for(Planet p : ps) {
            if(!p.equals(this)) {
                sum += calcForceExertedByX(p);
            }
        }
        return sum;
    }
    public double calcNetForceExertedByY(Planet[] ps) {
        double sum=0.0;
        for(Planet p : ps) {
            if(!p.equals(this)) {
                sum += calcForceExertedByY(p);
            }
        }
        return sum;
    }

    public void update(double seconds, double xforce, double yforce) {
        double accelx = xforce/myMass;
        double accely = yforce/myMass;

        double vnewx = myXVel+seconds*accelx;
        double vnewy = myYVel+seconds*accely;

        double pnewx = myXPos + seconds*vnewx;
        double pnewy = myYPos + seconds*vnewy;

        myXVel = vnewx;
        myYVel = vnewy;

        myXPos = pnewx;
        myYPos = pnewy;


    }
}
