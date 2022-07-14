package twoPointers

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int{
        var left = 0
        var right = height.size - 1
        var waterMax = 0
        while(left < right){
            val currentWaterHeight = minOf(height[left], height[right]) * (right - left)
            if(currentWaterHeight > waterMax)
                waterMax = currentWaterHeight

            if(height[left] > height[right])
                right--
            else
                left++
        }
        return waterMax
    }
}