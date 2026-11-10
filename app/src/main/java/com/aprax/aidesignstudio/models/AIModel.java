package com.aprax.aidesignstudio.models;
import android.os.Parcel;
import android.os.Parcelable;
public class AIModel implements Parcelable {
 public String modelId, displayName, shortName, provider, description, pricingTier, usageQuota, rateLimit, latency, contextWindow, supportedLanguages, safeContentFiltering, toolUse, functionCalling, imageGeneration, audioGeneration, codeGeneration, vision, speechToText, textToSpeech, multilingual, domainSpecific, reasoning, chainOfThought;
 public boolean freeTierEligible;
 public AIModel() {}
 protected AIModel(Parcel in) { modelId=in.readString(); displayName=in.readString(); shortName=in.readString(); provider=in.readString(); description=in.readString(); freeTierEligible=in.readByte()!=0; pricingTier=in.readString(); usageQuota=in.readString(); rateLimit=in.readString(); latency=in.readString(); contextWindow=in.readString(); supportedLanguages=in.readString(); safeContentFiltering=in.readString(); toolUse=in.readString(); functionCalling=in.readString(); imageGeneration=in.readString(); audioGeneration=in.readString(); codeGeneration=in.readString(); vision=in.readString(); speechToText=in.readString(); textToSpeech=in.readString(); multilingual=in.readString(); domainSpecific=in.readString(); reasoning=in.readString(); chainOfThought=in.readString(); }
 public static final Creator<AIModel> CREATOR=new Creator<AIModel>() { public AIModel createFromParcel(Parcel in){return new AIModel(in);} public AIModel[] newArray(int n){return new AIModel[n];} };
 public int describeContents(){return 0;}
 public void writeToParcel(Parcel d,int flags){d.writeString(modelId);d.writeString(displayName);d.writeString(shortName);d.writeString(provider);d.writeString(description);d.writeByte((byte)(freeTierEligible?1:0));d.writeString(pricingTier);d.writeString(usageQuota);d.writeString(rateLimit);d.writeString(latency);d.writeString(contextWindow);d.writeString(supportedLanguages);d.writeString(safeContentFiltering);d.writeString(toolUse);d.writeString(functionCalling);d.writeString(imageGeneration);d.writeString(audioGeneration);d.writeString(codeGeneration);d.writeString(vision);d.writeString(speechToText);d.writeString(textToSpeech);d.writeString(multilingual);d.writeString(domainSpecific);d.writeString(reasoning);d.writeString(chainOfThought);}
 public String getModelId(){return modelId;} public void setModelId(String v){modelId=v;}
 public String getDisplayName(){return displayName;} public void setDisplayName(String v){displayName=v;}
 public String getShortName(){return shortName;} public void setShortName(String v){shortName=v;}
 public String getProvider(){return provider;} public void setProvider(String v){provider=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public boolean isFreeTierEligible(){return freeTierEligible;} public void setFreeTierEligible(boolean v){freeTierEligible=v;}
 public String getPricingTier(){return pricingTier;} public void setPricingTier(String v){pricingTier=v;}
 public String getUsageQuota(){return usageQuota;} public void setUsageQuota(String v){usageQuota=v;}
 public String getRateLimit(){return rateLimit;} public void setRateLimit(String v){rateLimit=v;}
 public String getLatency(){return latency;} public void setLatency(String v){latency=v;}
 public String getContextWindow(){return contextWindow;} public void setContextWindow(String v){contextWindow=v;}
 public String getSupportedLanguages(){return supportedLanguages;} public void setSupportedLanguages(String v){supportedLanguages=v;}
 public String getSafeContentFiltering(){return safeContentFiltering;} public void setSafeContentFiltering(String v){safeContentFiltering=v;}
 public String getToolUse(){return toolUse;} public void setToolUse(String v){toolUse=v;}
 public String getFunctionCalling(){return functionCalling;} public void setFunctionCalling(String v){functionCalling=v;}
 public String getImageGeneration(){return imageGeneration;} public void setImageGeneration(String v){imageGeneration=v;}
 public String getAudioGeneration(){return audioGeneration;} public void setAudioGeneration(String v){audioGeneration=v;}
 public String getCodeGeneration(){return codeGeneration;} public void setCodeGeneration(String v){codeGeneration=v;}
 public String getVision(){return vision;} public void setVision(String v){vision=v;}
 public String getSpeechToText(){return speechToText;} public void setSpeechToText(String v){speechToText=v;}
 public String getTextToSpeech(){return textToSpeech;} public void setTextToSpeech(String v){textToSpeech=v;}
 public String getMultilingual(){return multilingual;} public void setMultilingual(String v){multilingual=v;}
 public String getDomainSpecific(){return domainSpecific;} public void setDomainSpecific(String v){domainSpecific=v;}
 public String getReasoning(){return reasoning;} public void setReasoning(String v){reasoning=v;}
 public String getChainOfThought(){return chainOfThought;} public void setChainOfThought(String v){chainOfThought=v;}
}
