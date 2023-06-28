#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class UIViewController, CBBBaseBuilder<COLOR, IMAGE, VIEW>, CBBRoleEnum, CBBDarkColors, CBBBaseColorsBuilder<T, C>, CBBDefaultColors, CBBChatBot, UIColor, UIImage, CBBColors, CBBKotlinEnumCompanion, CBBKotlinEnum<E>, CBBKotlinArray<T>;

@protocol CBBKotlinComparable, CBBKotlinIterator;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface CBBBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface CBBBase (CBBBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface CBBMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface CBBMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorCBBKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface CBBNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface CBBByte : CBBNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface CBBUByte : CBBNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface CBBShort : CBBNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface CBBUShort : CBBNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface CBBInt : CBBNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface CBBUInt : CBBNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface CBBLong : CBBNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface CBBULong : CBBNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface CBBFloat : CBBNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface CBBDouble : CBBNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface CBBBoolean : CBBNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((swift_name("ChatBot")))
@interface CBBChatBot : CBBBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (UIViewController *)getViewController __attribute__((swift_name("getViewController()")));
@end

__attribute__((swift_name("BaseBuilder")))
@interface CBBBaseBuilder<COLOR, IMAGE, VIEW> : CBBBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)addMessageRole:(CBBRoleEnum *)role content:(NSString *)content __attribute__((swift_name("addMessage(role:content:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)addPreSeededMessageRole:(CBBRoleEnum *)role content:(NSString *)content __attribute__((swift_name("addPreSeededMessage(role:content:)")));
- (VIEW)build __attribute__((swift_name("build()")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setBotIconImage:(IMAGE)image __attribute__((swift_name("setBotIcon(image:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setDarkColorsBuilderDarkColorsBuilder:(CBBBaseColorsBuilder<COLOR, CBBDarkColors *> *)darkColorsBuilder __attribute__((swift_name("setDarkColorsBuilder(darkColorsBuilder:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setDarkModeIsEnabled:(BOOL)isEnabled __attribute__((swift_name("setDarkMode(isEnabled:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setDefaultColorsBuilderDefaultColorsBuilder:(CBBBaseColorsBuilder<COLOR, CBBDefaultColors *> *)defaultColorsBuilder __attribute__((swift_name("setDefaultColorsBuilder(defaultColorsBuilder:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setErrorTextText:(NSString *)text __attribute__((swift_name("setErrorText(text:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setInputFieldBorderWidthBorderWidth:(int32_t)borderWidth __attribute__((swift_name("setInputFieldBorderWidth(borderWidth:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setInputFieldCornerRadiusCornerRadius:(int32_t)cornerRadius __attribute__((swift_name("setInputFieldCornerRadius(cornerRadius:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setInputFieldHintHint:(NSString *)hint __attribute__((swift_name("setInputFieldHint(hint:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setLogErrorIsEnabled:(BOOL)isEnabled __attribute__((swift_name("setLogError(isEnabled:)")));
- (CBBBaseBuilder<COLOR, IMAGE, VIEW> *)setMaxTokensTokens:(int32_t)tokens __attribute__((swift_name("setMaxTokens(tokens:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChatBot.Builder")))
@interface CBBChatBotBuilder : CBBBaseBuilder<UIColor *, UIImage *, CBBChatBot *>
- (instancetype)initWithApiKey:(NSString *)apiKey __attribute__((swift_name("init(apiKey:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (CBBChatBot *)build __attribute__((swift_name("build()")));
@end

__attribute__((swift_name("BaseColorsBuilder")))
@interface CBBBaseColorsBuilder<T, C> : CBBBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (uint64_t)colorFactoryColor:(T _Nullable)color __attribute__((swift_name("colorFactory(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setBackgroundColorColor:(T _Nullable)color __attribute__((swift_name("setBackgroundColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setBotBalloonColorColor:(T _Nullable)color __attribute__((swift_name("setBotBalloonColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setBotBalloonTextColorColor:(T _Nullable)color __attribute__((swift_name("setBotBalloonTextColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setDividerColorColor:(T _Nullable)color __attribute__((swift_name("setDividerColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setErrorTextColorColor:(T _Nullable)color __attribute__((swift_name("setErrorTextColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setInputFieldBackgroundColorColor:(T _Nullable)color __attribute__((swift_name("setInputFieldBackgroundColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setInputFieldFocusedIndicatorColorColor:(T _Nullable)color __attribute__((swift_name("setInputFieldFocusedIndicatorColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setInputFieldHintColorColor:(T _Nullable)color __attribute__((swift_name("setInputFieldHintColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setInputFieldTextColorColor:(T _Nullable)color __attribute__((swift_name("setInputFieldTextColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setInputFieldUnfocusedIndicatorColorColor:(T _Nullable)color __attribute__((swift_name("setInputFieldUnfocusedIndicatorColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setLoadingTextColorColor:(T _Nullable)color __attribute__((swift_name("setLoadingTextColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setSendButtonColorColor:(T _Nullable)color __attribute__((swift_name("setSendButtonColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setUserBalloonColorColor:(T _Nullable)color __attribute__((swift_name("setUserBalloonColor(color:)")));
- (CBBBaseColorsBuilder<T, C> *)setUserBalloonTextColorColor:(T _Nullable)color __attribute__((swift_name("setUserBalloonTextColor(color:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChatBot.DarkColorsBuilder")))
@interface CBBChatBotDarkColorsBuilder : CBBBaseColorsBuilder<UIColor *, CBBDarkColors *>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (uint64_t)colorFactoryColor:(UIColor *)color __attribute__((swift_name("colorFactory(color:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChatBot.DefaultColorsBuilder")))
@interface CBBChatBotDefaultColorsBuilder : CBBBaseColorsBuilder<UIColor *, CBBDefaultColors *>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (uint64_t)colorFactoryColor:(UIColor *)color __attribute__((swift_name("colorFactory(color:)")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((swift_name("Colors")))
@interface CBBColors : CBBBase
- (instancetype)initWithBackgroundColor:(uint64_t)backgroundColor userBalloonColor:(uint64_t)userBalloonColor userBalloonTextColor:(uint64_t)userBalloonTextColor botBalloonColor:(uint64_t)botBalloonColor botBalloonTextColor:(uint64_t)botBalloonTextColor inputFieldBackgroundColor:(uint64_t)inputFieldBackgroundColor inputFieldTextColor:(uint64_t)inputFieldTextColor inputFieldHintColor:(uint64_t)inputFieldHintColor inputFieldFocusedIndicatorColor:(uint64_t)inputFieldFocusedIndicatorColor inputFieldUnfocusedIndicatorColor:(uint64_t)inputFieldUnfocusedIndicatorColor cursorColor:(uint64_t)cursorColor sendButtonColor:(uint64_t)sendButtonColor dividerColor:(uint64_t)dividerColor loadingTextColor:(uint64_t)loadingTextColor errorTextColor:(uint64_t)errorTextColor __attribute__((swift_name("init(backgroundColor:userBalloonColor:userBalloonTextColor:botBalloonColor:botBalloonTextColor:inputFieldBackgroundColor:inputFieldTextColor:inputFieldHintColor:inputFieldFocusedIndicatorColor:inputFieldUnfocusedIndicatorColor:cursorColor:sendButtonColor:dividerColor:loadingTextColor:errorTextColor:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DarkColors")))
@interface CBBDarkColors : CBBColors
- (instancetype)initWithBackgroundColor:(uint64_t)backgroundColor userBalloonColor:(uint64_t)userBalloonColor userBalloonTextColor:(uint64_t)userBalloonTextColor botBalloonColor:(uint64_t)botBalloonColor botBalloonTextColor:(uint64_t)botBalloonTextColor inputFieldBackgroundColor:(uint64_t)inputFieldBackgroundColor inputFieldTextColor:(uint64_t)inputFieldTextColor inputFieldHintColor:(uint64_t)inputFieldHintColor inputFieldFocusedIndicatorColor:(uint64_t)inputFieldFocusedIndicatorColor inputFieldUnfocusedIndicatorColor:(uint64_t)inputFieldUnfocusedIndicatorColor cursorColor:(uint64_t)cursorColor sendButtonColor:(uint64_t)sendButtonColor dividerColor:(uint64_t)dividerColor loadingTextColor:(uint64_t)loadingTextColor errorTextColor:(uint64_t)errorTextColor __attribute__((swift_name("init(backgroundColor:userBalloonColor:userBalloonTextColor:botBalloonColor:botBalloonTextColor:inputFieldBackgroundColor:inputFieldTextColor:inputFieldHintColor:inputFieldFocusedIndicatorColor:inputFieldUnfocusedIndicatorColor:cursorColor:sendButtonColor:dividerColor:loadingTextColor:errorTextColor:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DefaultColors")))
@interface CBBDefaultColors : CBBColors
- (instancetype)initWithBackgroundColor:(uint64_t)backgroundColor userBalloonColor:(uint64_t)userBalloonColor userBalloonTextColor:(uint64_t)userBalloonTextColor botBalloonColor:(uint64_t)botBalloonColor botBalloonTextColor:(uint64_t)botBalloonTextColor inputFieldBackgroundColor:(uint64_t)inputFieldBackgroundColor inputFieldTextColor:(uint64_t)inputFieldTextColor inputFieldHintColor:(uint64_t)inputFieldHintColor inputFieldFocusedIndicatorColor:(uint64_t)inputFieldFocusedIndicatorColor inputFieldUnfocusedIndicatorColor:(uint64_t)inputFieldUnfocusedIndicatorColor cursorColor:(uint64_t)cursorColor sendButtonColor:(uint64_t)sendButtonColor dividerColor:(uint64_t)dividerColor loadingTextColor:(uint64_t)loadingTextColor errorTextColor:(uint64_t)errorTextColor __attribute__((swift_name("init(backgroundColor:userBalloonColor:userBalloonTextColor:botBalloonColor:botBalloonTextColor:inputFieldBackgroundColor:inputFieldTextColor:inputFieldHintColor:inputFieldFocusedIndicatorColor:inputFieldUnfocusedIndicatorColor:cursorColor:sendButtonColor:dividerColor:loadingTextColor:errorTextColor:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinComparable")))
@protocol CBBKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface CBBKotlinEnum<E> : CBBBase <CBBKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CBBKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RoleEnum")))
@interface CBBRoleEnum : CBBKotlinEnum<CBBRoleEnum *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) CBBRoleEnum *system __attribute__((swift_name("system")));
@property (class, readonly) CBBRoleEnum *user __attribute__((swift_name("user")));
@property (class, readonly) CBBRoleEnum *assistant __attribute__((swift_name("assistant")));
+ (CBBKotlinArray<CBBRoleEnum *> *)values __attribute__((swift_name("values()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface CBBKotlinEnumCompanion : CBBBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CBBKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface CBBKotlinArray<T> : CBBBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(CBBInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<CBBKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol CBBKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
