// LegacyAPI class
class LegacyAPI {
    
    // Deprecated method
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }

    // Recommended new method
    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        // This will show a warning in most IDEs or during compilation
        api.oldFeature();
        
        api.newFeature();
    }
}

