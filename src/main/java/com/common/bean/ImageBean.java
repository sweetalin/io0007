package com.common.bean;
/***
 * 减少图片大小时的配置
 * @author huangwei
 * @since 2014年10月21日
 */
public class ImageBean {
	/***
	 * 压缩质量，在0-1之间
	 */
	private float quality;
	/***
	 * 是否修改尺寸
	 */
	private boolean isScale;
	/***
	 * 只有当isScale 为true时fixedWidth 才有用
	 */
	private int fixedWidth;
	public float getQuality() {
		return quality;
	}
	public void setQuality(float quality) {
		this.quality = quality;
	}
	public boolean isScale() {
		return isScale;
	}
	public void setScale(boolean isScale) {
		this.isScale = isScale;
	}
	public int getFixedWidth() {
		return fixedWidth;
	}
	public void setFixedWidth(int fixedWidth) {
		this.fixedWidth = fixedWidth;
	}
	
	
	
}
