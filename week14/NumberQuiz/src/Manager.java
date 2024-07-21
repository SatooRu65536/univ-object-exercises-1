public class Manager {
    private int count;
    private Answer answer;
    enum Response {
        UP,
        DOWN,
        CORRECT
    }

    public Manager() {
        this.count = 0;
        this.answer = new Answer();
    }

    public int getCount() {
        return this.count;
    }

    public Answer getAnswer() {
        return this.answer;
    }

    public Response solve(String inputString) {
        this.count++;

        String answerString = this.answer.get();
        Integer answer = Integer.parseInt(answerString);
        Integer input = Integer.parseInt(inputString);

        if (answer.equals(input)) {
            return Response.CORRECT;
        }

        if (answer < input) {
            return Response.UP;
        }

        return Response.DOWN;
    }
}
