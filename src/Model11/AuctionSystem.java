package Model11;

import java.util.List;

public class AuctionSystem {
    // 2. 경매 시스템 클래스: 제2가격 봉인입찰 규칙 구현

    public static class Result {
        Bidder winner;
        double secondPrice;

        public Result(Bidder winner, double secondPrice) {
            this.winner = winner;
            this.secondPrice = secondPrice;
        }
    }

    public Result runAuction(List<Bidder> bidders) {
        // 입찰가 기준으로 입찰자들을 정렬 (내림차순)
        bidders.sort((b1, b2) -> Double.compare(b2.placeBid(), b1.placeBid()));

        Bidder winner = bidders.get(0);
        double secondPrice = bidders.get(1).placeBid(); // 2등의 입찰가

        return new Result(winner, secondPrice);
    }

}
