package turtlerace.domain;



public class RaceLogic {
    private Turtle turtle;
    private int moveAmount;
    private int step;
    private int initialMove;
    
    public RaceLogic() {
        initialMove = 5;
    }
    
    
    /**
     * Moves the given turtle according to it's attributes.
     * @param step Current "time" in the race
     * @param turtle The turtle that is moved
     * @return Returns the amount the turtle should be moved.
     */
    public int moveTurtle(int step, Turtle turtle) {
        this.turtle = turtle;
        this.step = step;
        this.moveAmount = initialMove;
        
        if (turtle.getNeutral() == 0) {
            
            applySupport();
            
            return moveAmount;
        }
        
        applyAdvantage();
        
        applyDisadvantage();
        
        applySupport();
        
        return moveAmount;
    }
    
    
    
    private void applyAdvantage() {
        switch (turtle.getAdvantage()) {
            case 0:
                advantage1();
                break;
            case 1:
                advantage2();
                break;
            case 2:
                advantage3();
                break;
            case 3:
                advantage4();
                break;
            case 4:
                advantage5();
                break;
            default:
                System.out.println("Error, default advantage");
                advantage1();
                break;
        }
    }
    
    private void applyDisadvantage() {
        switch (turtle.getHandicap()) {
            case 0:
                disadvantage1();
                break;
            case 1:
                disadvantage2();
                break;
            case 2:
                disadvantage3();
                break;
            case 3:
                disadvantage4();
                break;
            case 4:
                disadvantage5();
                break;
            default:
                System.out.println("Error, default disability");
                disadvantage1();
                break;
        }
    }
    
    private void applySupport() {
        switch (turtle.getSupport()) {
            case 0:
                support1();
                break;
            case 1:
                support2();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Error, default support");
                break;
        }
    }
    
    
    
    
    // Effects
    
    private void advantage1() {
        if (turtle.getNeutral() == 1) {
            moveAmount = 14;
        }
        
        moveAmount = 7;
    }
    
    private void advantage2() {
        if (turtle.getNeutral() == 1) {
            if (step == 1) {
                moveAmount = 120;
            }
            if (step == 2) {
                moveAmount = 40;
            }
            return;
        }
        
        if (step == 1) {
            moveAmount = 50;
        }
        if (step == 2) {
            moveAmount = 20;
        }
    }
    
    private void advantage3() {
        if (turtle.getNeutral() == 1) {
            if (step % 15 == 0) {
                moveAmount = 40;
            }
            return;
        }
        
        if (step % 15 == 0) {
            moveAmount = 20;
        }
    }
    
    private void advantage4() {
        if (turtle.getNeutral() == 1) {
            if (step <= 15) {
                moveAmount = 2;
            }
            if (step > 50) {
                moveAmount = 20;
            }
            return;
        }
        
        if (step <= 10) {
            moveAmount = 2;
        }
        if (step > 50) {
            moveAmount = 13;
        }
    }
    
    private void advantage5() {
        if (turtle.getSupport() == 2) {
            if (step == 40) {
                moveAmount = 80;
            }
            if (step == 41) {
                moveAmount = 80;
            }
            return;
        }
        
        if (turtle.getNeutral() == 1) {
            if (step == 40) {
                moveAmount = 120;
            }
            return;
        }
        
        if (step == 40) {
            moveAmount = 80;
        }
    }
    
    //-----------------------------------------------
    
    private void support1() {
        if (step <= 5) {
            moveAmount += 7;
        }
    }
    
    private void support2() {
        if (step == 50) {
            moveAmount += 100;
        }
        if (step > 50 && step < 65) {
            moveAmount = 0;
        }
    }
    
    //-----------------------------------------------
    
    private void disadvantage1() {
        if (turtle.getSupport() == 2) {
            moveAmount -= 1;
            return;
        }
        
        if (turtle.getNeutral() == 1) {
            moveAmount -= 3;
            return;
        }
        
        moveAmount -= 2;
    }
    
    private void disadvantage2() {
        if (turtle.getSupport() == 2) {
            if (step <= 2) {
                moveAmount = 0;
            }
            return;
        }
        
        if (turtle.getNeutral() == 1) {
            if (step <= 4) {
                moveAmount = 0;
            }
            return;
        }
        
        if (step <= 3) {
            moveAmount = 0;
        }
    }
    
    private void disadvantage3() {
        if (turtle.getSupport() == 2) {
            if (step % 10 == 0) {
                moveAmount += -5;
            }
            return;
        }
        
        if (turtle.getNeutral() == 1) {
            if (step % 10 == 0) {
                moveAmount += -13;
            }
            return;
        }
        
        if (step % 10 == 0) {
            moveAmount += -10;
        }
    }
    
    private void disadvantage4() {
        if (turtle.getSupport() == 2) {
            if (step >= 40 && step < 60) {
                moveAmount /= 2;
                moveAmount += 2;
            }
            return;
        }
        
        if (turtle.getNeutral() == 1) {
            if (step >= 40 && step < 60) {
                moveAmount /= 3;
            }
            return;
        }
        
        if (step >= 40 && step < 60) {
            moveAmount /= 2;
        }
    }
    
    private void disadvantage5() {
        if (turtle.getSupport() == 2) {
            if (step == 10) {
                moveAmount = -20;
            }
            return;
        }
        
        if (turtle.getNeutral() == 1) {
            if (step == 20) {
                moveAmount = -65;
            }
            return;
        }
        
        if (step == 10) {
            moveAmount = -50;
        }
    }
    
    
    
    // Test methods
    /**
     * Used for testing
     * @return Returns moveAmount of 01x4 on step stp
     */
    public int apply01x4(int stp, int neut) {
        moveAmount = initialMove;
        step = stp;
        
        Turtle testTurtle = new Turtle(0);
        testTurtle.setSupport(1);
        testTurtle.setNeutral(neut);
        turtle = testTurtle;
        
        if (neut != 0) {
            advantage1();
            disadvantage5();
        }
        support2();
        
        return moveAmount;
    }
}
