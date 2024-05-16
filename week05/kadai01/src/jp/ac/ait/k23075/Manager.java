package jp.ac.ait.k23075;

public class Manager {
    private int count;
    private Answer answer;

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

    public Response solve(String in) {
        this.count++;

        String answer = this.answer.get();
        int hit = 0;
        int blow = 0;

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < answer.length(); j++) {
                if (answer.charAt(i) != in.charAt(j)) {
                    continue;
                }

                if (i == j) {
                    hit++;
                } else {
                    blow++;

                }
            }
        }

        Response response = new Response(hit, blow);

        return response;
    }
}
