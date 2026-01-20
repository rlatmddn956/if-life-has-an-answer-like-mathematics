package Model11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuctionDemo {
    // 3. 메인 실행 클래스: 시뮬레이션 수행 및 결과 집계

        public static void main(String[] args) {
            int trials = 10000; // 1만 번 반복 실험
            double totalUnder = 0, totalTruth = 0, totalOver = 0;
            Random random = new Random();
            AuctionSystem auction = new AuctionSystem();

            for (int i = 0; i < trials; i++) {
                double myValue = 100.0;

                // 실험 대상인 '나'의 3가지 자아
                Bidder meUnder = new Bidder("Under", myValue, 0.8);
                Bidder meTruth = new Bidder("Truth", myValue, 1.0);
                Bidder meOver = new Bidder("Over", myValue, 1.2);

                // 매판 달라지는 경쟁자 5명 (가치 70~130 사이 무작위)
                List<Bidder> competitors = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    competitors.add(new Bidder("C" + j, 70 + random.nextDouble() * 60, 1.0));
                }

                // 전략별로 경매 참여 및 이득 합산
                totalUnder += runSingleTrial(auction, meUnder, competitors);
                totalTruth += runSingleTrial(auction, meTruth, competitors);
                totalOver += runSingleTrial(auction, meOver, competitors);
            }

            // 결과 출력
            System.out.println("=== 10,000회 경매 시뮬레이션 결과 ===");
            System.out.printf("과소 입찰(80%%) 평균 이득: %.2f\n", totalUnder / trials);
            System.out.printf("정직 입찰(100%%) 평균 이득: %.2f\n", totalTruth / trials);
            System.out.printf("과다 입찰(120%%) 평균 이득: %.2f\n", totalOver / trials);
        }

        private static double runSingleTrial(AuctionSystem auction, Bidder me, List<Bidder> competitors) {
            List<Bidder> participants = new ArrayList<>(competitors);
            participants.add(me);
            AuctionSystem.Result res = auction.runAuction(participants);
            return me.calculatePayoff(res.winner == me, res.secondPrice);
        }
}
