package Model11;

public class Bidder {
        // 1. 입찰자 클래스: 각 입찰자의 성격과 가치를 정의함

        String name;
        double trueValue;      // 본인이 생각하는 실제 가치
        double strategyRatio;  // 입찰 전략 비율 (1.0 = 정직, 0.8 = 과소, 1.2 = 과다)

        public Bidder(String name, double trueValue, double strategyRatio) {
            this.name = name;
            this.trueValue = trueValue;
            this.strategyRatio = strategyRatio;
        }

        // 전략에 따른 입찰가 생성
        public double placeBid() {
            return this.trueValue * this.strategyRatio;
        }

        // 낙찰 시 이득 계산
        public double calculatePayoff(boolean isWinner, double pricePaid) {
            if (isWinner) {
                return this.trueValue - pricePaid;
            }
            return 0;
        }
}
