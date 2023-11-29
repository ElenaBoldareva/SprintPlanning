public class UserStory extends Ticket {
    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory[] dependencies) {
        super(id, name, estimate);
        this.dependencies = dependencies;
    }

    @Override
    public void complete() {
        for (UserStory story : dependencies) {
            if (!story.isCompleted()) {
                return;
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        return dependencies.clone();
    }

    public String toString() {
        return "[US " + getId() + "] User Registration Entity";
    }

}
