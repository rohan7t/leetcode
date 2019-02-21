class Solution:
    def maxProfit(self, prices: 'List[int]') -> 'int':
        if not prices or len(prices) <= 1:
            return 0
        max_profit = 0
        min_price = prices[0]
        max_price = prices[0]
        for price in prices:
            if price > max_price:
                max_price = price
                max_profit = max(max_profit, max_price-min_price)
            if price < min_price:
                min_price = price
                max_price = -1
        return max_profit
